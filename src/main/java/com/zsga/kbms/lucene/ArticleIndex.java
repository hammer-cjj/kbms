package com.zsga.kbms.lucene;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.zsga.kbms.entity.Article;
import com.zsga.kbms.utils.DateUtil;
import com.zsga.kbms.utils.StringUtil;


/**
 * 文章索引类
 * @author admin
 *
 */
public class ArticleIndex {
	private Directory dir = null;
	
	/**
	 * 获取IndexWriter实例
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter() throws Exception {
		dir = FSDirectory.open(Paths.get("C:/Users/admin/Desktop/workspace/lucene"));
		SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
		IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * 添加索引
	 * @param article
	 * @throws Exception
	 */
	public void addIndex(Article article) throws Exception {
		IndexWriter indexWriter = getWriter();
		Document doc=new Document();
		doc.add(new StringField("id",String.valueOf(article.getId()),Field.Store.YES));
		doc.add(new TextField("title",article.getTitle(),Field.Store.YES));
		doc.add(new StringField("releaseDate",DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
		doc.add(new TextField("content",article.getContentNoTag(),Field.Store.YES));
		indexWriter.addDocument(doc);
		indexWriter.close();
	}
	
	/**
	 * 更新文章索引
	 * @param article
	 * @throws Exception
	 */
	public void updateIndex(Article article) throws Exception {
		IndexWriter indexWriter = getWriter();
		Document doc=new Document();
		doc.add(new StringField("id",String.valueOf(article.getId()),Field.Store.YES));
		doc.add(new TextField("title",article.getTitle(),Field.Store.YES));
		doc.add(new StringField("releaseDate",DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
		doc.add(new TextField("content",article.getContentNoTag(),Field.Store.YES));
		indexWriter.updateDocument(new Term("id", String.valueOf(article.getId())), doc);
		indexWriter.close();
	}
	
	/**
	 * 删除文章索引
	 * @param articleId
	 * @throws Exception
	 */
	public void deleteIndex(String articleId) throws Exception {
		IndexWriter indexWriter = getWriter();
		indexWriter.deleteDocuments(new Term("id",articleId));
		indexWriter.forceMergeDeletes(); // 强制删除
		indexWriter.commit();
		indexWriter.close();
	}
	
	/**
	 * 查询文章信息
	 * @param q 查询关键字
	 * @return
	 * @throws Exception
	 */
	public List<Article> searchArticle(String q) throws Exception {
		dir=FSDirectory.open(Paths.get("C:/Users/admin/Desktop/workspace/lucene"));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		
		//多条件查询
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		//中文分词
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		
		QueryParser parser = new QueryParser("title",analyzer);
		Query query = parser.parse(q);
		QueryParser parser2 = new QueryParser("content",analyzer);
		Query query2 = parser2.parse(q);
		//添加条件
		booleanQuery.add(query, BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
		//查询前100项
		TopDocs hits = is.search(booleanQuery.build(), 100);
		
		//高亮显示
		QueryScorer scorer=new QueryScorer(query);  
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);  
		SimpleHTMLFormatter simpleHTMLFormatter=new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter=new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);  
		
		List<Article> articleList = new LinkedList<Article>();
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc = is.doc(scoreDoc.doc);
			Article article = new Article();
			article.setId(Integer.parseInt(doc.get("id")));
			article.setReleaseDateStr(doc.get(("releaseDate")));
			String title = doc.get("title");
			String content = StringEscapeUtils.escapeHtml(doc.get("content"));
			if(title!=null){
				//设置得分最高的片段（摘要）
				TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
				String hTitle=highlighter.getBestFragment(tokenStream, title);
				if(StringUtil.isEmpty(hTitle)){
					article.setTitle(title);
				}else{
					article.setTitle(hTitle);					
				}
			}
			if(content!=null){
				TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content)); 
				String hContent=highlighter.getBestFragment(tokenStream, content);
				if(StringUtil.isEmpty(hContent)){
					if(content.length()<=200){
						article.setContent(content);
					}else{
						article.setContent(content.substring(0, 200));						
					}
				}else{
					article.setContent(hContent);					
				}
			}
			articleList.add(article);
		}
		return articleList;
	}
}

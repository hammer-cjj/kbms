package com.zsga.kbms.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传Controller层
 * @author admin
 *
 */
@Controller
public class UploadController {

	@RequestMapping(value="/uploadImage",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)     
    @ResponseBody
    public Map<String,Object> uploadFile(@RequestParam(value = "upfile", required = false) MultipartFile file,
    		HttpServletResponse response){ 
		Map<String,Object> map = new HashMap<String, Object>();  
		String realName = null;  
        String uuidName = null;  
        String realPath = null; 
		try {
			//文件原来的名称  
            realName = getRealName(file.getOriginalFilename());  
            //得到这个文件的uuidname  
            uuidName = this.getUUIDFileName(file.getOriginalFilename());  
            //这里测试的是 把图片不存在 发布目录下  
            realPath  = "d:/images"; 
            
            //得到文件的输入流  
            InputStream in = new BufferedInputStream(file.getInputStream());  
              
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(realPath,uuidName)));  
              
            IOUtils.copy(in, out);  
            in.close();  
            out.close();
            
            map.put("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容  
            map.put("url","/images/"+uuidName);         //能访问到你现在图片的路径 这里  
            map.put("title","");  
            map.put("original",realName);
            
		} catch (Exception e) {
			map.put("state", "文件上传失败!"); //在此处写上错误提示信息，这样当错误的时候就会显示此信息  
            map.put("url","");  
            map.put("title", "");  
            map.put("original", "");
			e.printStackTrace();
		}
		return map;
	}
	
	 private String getExtName(String s, char split) {    
         int i = s.lastIndexOf(split);    
         int leg = s.length();    
         return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";    
     }    
     
   private String getUUIDFileName(String fileName){    
          UUID uuid = UUID.randomUUID();    
          StringBuilder sb = new StringBuilder(100);    
          sb.append(uuid.toString()).append(".").append(this.getExtName(fileName, '.'));    
          return sb.toString();    
      }  
     
   private String getRealName(String originalName){  
       //System.out.println(originalName.contains("."));  
         
       if(originalName.contains(".")){  
	      String [] as = originalName.split("\\.");  
	      //System.out.println(as[0]);  
	      return as[0];  
       }else {  
          return originalName;  
      }  
   } 
    
}

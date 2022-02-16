package org.fkit.fileuploadtest.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.fkit.fileuploadtest.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	// 映射"/"请求
	@RequestMapping("/")
	public String index(){
		// 根据Thymeleaf默认模板，将返回resources/templates/index.html
		return "index";
	}




	@RequestMapping("/qw")
	public String indexqw(){

		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<RemitApplication><HDR><SendFrom>FDIMS</SendFrom><SendTo>FCSTP</SendTo><MQDate>20201028</MQDate><MQFormat>XML</MQFormat><MQCode>7994</MQCode></HDR><BranchNo>794</BranchNo><TranMngNo>IMT794205000058</TranMngNo><Status>0</Status><SenderBIC>2</SenderBIC><OSNNo>000000</OSNNo><Tg20RefNo>0000</Tg20RefNo><Tg23bBkOpCd></Tg23bBkOpCd><Tg23eInst1></Tg23eInst1><Tg23eInstInf1></Tg23eInstInf1><Tg23eInst2></Tg23eInst2><Tg23eInstInf2></Tg23eInstInf2><Tg23eInst3></Tg23eInst3><Tg23eInstInf3></Tg23eInstInf3><Tg23eInst4></Tg23eInst4><Tg23eInstInf4></Tg23eInstInf4><Tg23eInst5></Tg23eInst5><Tg23eInstInf5></Tg23eInstInf5><Tg23eInst6></Tg23eInst6><Tg23eInstInf6></Tg23eInstInf6><Tg23eInst7></Tg23eInst7><Tg23eInstInf7></Tg23eInstInf7><Tg23eInst8></Tg23eInst8><Tg23eInstInf8></Tg23eInstInf8><Tg23eInst9></Tg23eInst9><Tg23eInstInf9></Tg23eInstInf9><Tg26tTrnTyp></Tg26tTrnTyp><Tg32aDate>2020/10/28</Tg32aDate><Tg32aCcy>JPY</Tg32aCcy><Tg32aAmt>2</Tg32aAmt><Tg33bCcy></Tg33bCcy><Tg33bAmt></Tg33bAmt><Tg36Rate></Tg36Rate><Tg50Opt>K</Tg50Opt><Tg50AccNoSwift></Tg50AccNoSwift><Tg50Bic></Tg50Bic><Tg50NmAdd1>2</Tg50NmAdd1><Tg50NmAdd2></Tg50NmAdd2><Tg50NmAdd3></Tg50NmAdd3><Tg50NmAdd4></Tg50NmAdd4><Tg50CdId></Tg50CdId><Tg52Opt></Tg52Opt><Tg52PrtyId></Tg52PrtyId><Tg52Bic></Tg52Bic><Tg52NmAdd1></Tg52NmAdd1><Tg52NmAdd2></Tg52NmAdd2><Tg52NmAdd3></Tg52NmAdd3><Tg52NmAdd4></Tg52NmAdd4><Tg53Opt></Tg53Opt><Tg53PrtyId></Tg53PrtyId><Tg53Bic></Tg53Bic><Tg53Lctn></Tg53Lctn><Tg53NmAdd1></Tg53NmAdd1><Tg53NmAdd2></Tg53NmAdd2><Tg53NmAdd3></Tg53NmAdd3><Tg53NmAdd4></Tg53NmAdd4><Tg54Opt></Tg54Opt><Tg54PrtyId></Tg54PrtyId><Tg54Bic></Tg54Bic><Tg54Lctn></Tg54Lctn><Tg54NmAdd1></Tg54NmAdd1><Tg54NmAdd2></Tg54NmAdd2><Tg54NmAdd3></Tg54NmAdd3><Tg54NmAdd4></Tg54NmAdd4><Tg55Opt></Tg55Opt><Tg55PrtyId></Tg55PrtyId><Tg55Bic></Tg55Bic><Tg55Lctn></Tg55Lctn><Tg55NmAdd1></Tg55NmAdd1><Tg55NmAdd2></Tg55NmAdd2><Tg55NmAdd3></Tg55NmAdd3><Tg55NmAdd4></Tg55NmAdd4><Tg56Opt></Tg56Opt><Tg56PrtyId></Tg56PrtyId><Tg56Bic></Tg56Bic><Tg56NmAdd1></Tg56NmAdd1><Tg56NmAdd2></Tg56NmAdd2><Tg56NmAdd3></Tg56NmAdd3><Tg56NmAdd4></Tg56NmAdd4><Tg57Opt></Tg57Opt><Tg57PrtyId></Tg57PrtyId><Tg57Bic></Tg57Bic><Tg57Lctn></Tg57Lctn><Tg57NmAdd1></Tg57NmAdd1><Tg57NmAdd2></Tg57NmAdd2><Tg57NmAdd3></Tg57NmAdd3><Tg57NmAdd4></Tg57NmAdd4><Tg59Opt></Tg59Opt><Tg59AccNoSwift></Tg59AccNoSwift><Tg59Bic></Tg59Bic><Tg59NmAdd1>2</Tg59NmAdd1><Tg59NmAdd2></Tg59NmAdd2><Tg59NmAdd3></Tg59NmAdd3><Tg59NmAdd4></Tg59NmAdd4><Tg70Row1></Tg70Row1><Tg70Row2></Tg70Row2><Tg70Row3></Tg70Row3><Tg70Row4></Tg70Row4><Tg71aChrg>SHA</Tg71aChrg><Tg71fSndrChrgCcy1></Tg71fSndrChrgCcy1><Tg71fSndrChrgAmt1></Tg71fSndrChrgAmt1><Tg71fSndrChrgCcy2></Tg71fSndrChrgCcy2><Tg71fSndrChrgAmt2></Tg71fSndrChrgAmt2><Tg71fSndrChrgCcy3></Tg71fSndrChrgCcy3><Tg71fSndrChrgAmt3></Tg71fSndrChrgAmt3><Tg71gRcvrChrgCcy></Tg71gRcvrChrgCcy><Tg71gRcvrChrgAmt></Tg71gRcvrChrgAmt><Tg72Row1></Tg72Row1><Tg72Row2></Tg72Row2><Tg72Row3></Tg72Row3><Tg72Row4></Tg72Row4><Tg72Row5></Tg72Row5><Tg72Row6></Tg72Row6><Tg77bRow1></Tg77bRow1><Tg77bRow2></Tg77bRow2><Tg77bRow3></Tg77bRow3><BeneAccNo></BeneAccNo></RemitApplication>";

		String tranMngNo="IMT794205000058";
		String backFilePath="E://MQ_BACKUP//LOCAL_IR//";

		FileUtil.createXmlFile(xml, tranMngNo, backFilePath);


		return "qw";
	}





	
	@RequestMapping("/registerForm")
	public String registerForm(){
		return "registerForm";
	}
	
	// 上传文件会自动绑定到MultipartFile中
	 @PostMapping(value="/upload")
	 public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception{
		// 接收参数description
	    System.out.println("description = " + description);
	    // 如果文件不为空，写入上传路径
		if(!file.isEmpty()){
			// 上传文件路径
			String path = request.getServletContext().getRealPath(
	                "/upload/");
			System.out.println("path = " + path);
			// 上传文件名
			String filename = file.getOriginalFilename();
		    File filepath = new File(path,filename);
			// 判断路径是否存在，如果不存在就创建一个
	        if (!filepath.getParentFile().exists()) { 
	        	filepath.getParentFile().mkdirs();
	        }
	        // 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path+File.separator+ filename));
			return "success";
		}else{
			return "error";
		}
		 
	 }
	 
	 @RequestMapping(value="/register")
	 public String register(HttpServletRequest request,
			 @ModelAttribute User user,
			 Model model)throws Exception{
		// 接收参数username
		System.out.println("username = " +user.getUsername());
		// 如果文件不为空，写入上传路径
		if(!user.getHeadPortrait().isEmpty()){
			// 上传文件路径
			String path = request.getServletContext().getRealPath(
	                "/upload/");
			System.out.println("path = " + path);
			// 上传文件名
			String filename = user.getHeadPortrait().getOriginalFilename();
		    File filepath = new File(path,filename);
			// 判断路径是否存在，如果不存在就创建一个
	        if (!filepath.getParentFile().exists()) { 
	        	filepath.getParentFile().mkdirs();
	        }
	        // 将上传文件保存到一个目标文件当中
	        user.getHeadPortrait().transferTo(new File(path+File.separator+ filename));
	        // 将用户添加到model
	        model.addAttribute("user", user);
	        return "userInfo";
		}else{
			return "error";
		}
	}
	 
	 @RequestMapping(value="/download")
	 public ResponseEntity<byte[]> download(HttpServletRequest request,
			 @RequestParam("filename") String filename,
			 @RequestHeader("User-Agent") String userAgent,
			 Model model)throws Exception{
		// 下载文件路径
		String path = request.getServletContext().getRealPath(
                "/upload/");
		// 构建File
		File file = new File(path+File.separator+ filename);
		// ok表示Http协议中的状态 200
        BodyBuilder builder = ResponseEntity.ok();
        // 内容长度
        builder.contentLength(file.length());
        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用URLDecoder.decode对文件名进行解码
        filename = URLEncoder.encode(filename, "UTF-8");
        // 设置实际的响应文件名，告诉浏览器文件要用于【下载】、【保存】attachment 以附件形式
        // 不同的浏览器，处理方式不同，要根据浏览器版本进行区别判断
        if (userAgent.indexOf("MSIE") > 0) {
                // 如果是IE，只需要用UTF-8字符集进行URL编码即可
                builder.header("Content-Disposition", "attachment; filename=" + filename);
        } else {
                // 而FireFox、Chrome等浏览器，则需要说明编码的字符集
                // 注意filename后面有个*号，在UTF-8后面有两个单引号！
                builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
        }
        return builder.body(FileUtils.readFileToByteArray(file));
	 }
	
}

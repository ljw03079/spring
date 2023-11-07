package com.yedam.app.board;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadController {
	@Value("${file.upload.path}")
	private String uploadPath;

	@GetMapping("upload")
	public void getUploadPath() {}

	@PostMapping("/uploadsAjax")
	@ResponseBody
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) {
		// �������� ���ÿ� ������ ������ �迭���� multipartfile
		List<String> imageList = new ArrayList<>();

		for (MultipartFile uploadFile : uploadFiles) {
			// �̹����� header�� image ������ ��� ����
			if (uploadFile.getContentType().startsWith("image") == false) {
				System.err.println("this file is not image type");
				return null;
			}

			// ���� �����̸�
			String originalName = uploadFile.getOriginalFilename();
			String fileName = originalName.substring(originalName.lastIndexOf("//") + 1);

			System.out.println("fileName : " + fileName);

			// ��¥ �ڵ� ���� -> �Ⱓ�� �������� ������ �ڵ� �����ϱ� ����..
			
			// ��¥ ���� ����
			String folderPath = makeFolder();
			// UUID -> random���� �ٿ���.
			String uuid = UUID.randomUUID().toString();
			// ������ ���� �̸� �߰��� "_"�� �̿��Ͽ� ����
			
			// ���� �̸�
			String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;

			// ���� ������ ��θ� ���ڷ� ����.
			String saveName = uploadPath + File.separator + uploadFileName;

			// ���ڿ��� �Ѱ��ָ� ���� ���� ��θ� �������. -> transferTo�� �۵� 
			Path savePath = Paths.get(saveName);
			// Paths.get() �޼���� Ư�� ����� ���� ������ �����ɴϴ�.(��� �����ϱ�)
			System.out.println("path : " + saveName);
			try {
				uploadFile.transferTo(savePath);
				// uploadFile�� ������ ���ε� �ϴ� �޼��� transferTo(file)
			} catch (IOException e) {
				e.printStackTrace();
			}
			// DB�� �ش� ��� ����
			// 1) ����ڰ� ���ε��� �� ����� ���ϸ�
			// 2) ���� ������ ���ε��� �� ����� ���
			imageList.add(setImagePath(uploadFileName));
		}

		return imageList;
	}

	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate�� ���ڿ��� ����
		String folderPath = str.replace("/", File.separator);
		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"���ϸ�");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// ���� uploadPathFolder�� ���������ʴ´ٸ� makeDirectory�϶�� �ǹ��Դϴ�.
			// mkdir(): ���丮�� ���� ���丮�� �������� ������쿡�� ������ �Ұ����� �Լ�
			// mkdirs(): ���丮�� ���� ���丮�� �������� ���� ��쿡�� ���� ���丮���� ��� �����ϴ� �Լ�
		}
		return folderPath;
	}

	// ȭ�鿡�� ����ϴ� ���
	// separateor �ڹٰ� ��ο����� �������� �ν�
	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}

}

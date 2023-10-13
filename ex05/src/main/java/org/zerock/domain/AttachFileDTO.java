package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachFileDTO {
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean isImg;
}

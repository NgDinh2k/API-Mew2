package com.example.API.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AbstractDTO<T> {
	private Long id;
	private String createdBy;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;
	private String modifiedBy;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date modifiedDate;
}

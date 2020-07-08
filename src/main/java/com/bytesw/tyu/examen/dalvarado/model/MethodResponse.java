package com.bytesw.tyu.examen.dalvarado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodResponse {
	private String code;
	private String message;
	private Empresa emp;
}

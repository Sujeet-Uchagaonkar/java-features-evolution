package com.evolution.javafeatures.v11.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author USER
 *
 */
@Data
@AllArgsConstructor
public class Device {

	public String id;

	public String name;

	public DeviceData data;

	@AllArgsConstructor
	@Data
	static class DeviceData {
		public Integer year;

		public Double price;

		@JsonProperty("CPU model")
		public String cpuModel;

		@JsonProperty("Hard disk size")
		public String hardDiskSize;
	}


}

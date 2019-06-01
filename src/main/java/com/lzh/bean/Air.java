package com.lzh.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Air {

  private Long id;

  @NotNull(message = "区域的信息不能为空!")
  private Long districtId;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull(message = "检测时间不能为空!")
  private Date monitorTime;

  @NotNull(message = "pm10的信息不能为空!")
  private Long pm10;

  @NotNull(message = "pm25的信息不能为空!")
  private Long pm25;

  @NotBlank(message = "检测站不能为空!")
  private String monitoringStation;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date lastModifyTime;

  //映射返回区域name
  private String dName;


}

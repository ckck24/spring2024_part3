package org.zerock.ex00.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDTOList {

  private List<SampleDTO> list = new ArrayList<>();
}

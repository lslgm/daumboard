package com.daum.daumboard.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
    private  int no;
    private  String subject;
    private  String bcontent;
    private String name;
}

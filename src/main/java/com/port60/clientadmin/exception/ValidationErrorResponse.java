package com.port60.clientadmin.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ValidationErrorResponse {

  private List<Violation> violations = new ArrayList<>(1);

  // ...
}



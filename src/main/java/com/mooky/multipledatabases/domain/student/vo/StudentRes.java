package com.mooky.multipledatabases.domain.student.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StudentRes {
  private final long studentId;
  private final String firstName;
  private final String lastName;
  private final String email;
}

package com.mooky.multipledatabases.domain.teacher.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TeacherRes {
  private final long teacherId;
  private final String firstName;
  private final String lastName;
  private final String email;
}

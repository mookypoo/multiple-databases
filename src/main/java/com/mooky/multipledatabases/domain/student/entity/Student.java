package com.mooky.multipledatabases.domain.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seq")
  private @Getter Long id;

  @Column(unique = true, length = 200, nullable = false)
  private @Getter String email;

  @Column(unique = true, length = 100, nullable = false)
  private @Getter String firstName;

  @Column(unique = true, length = 100, nullable = false)
  private @Getter String lastName;

  public Student(String email, String firstName, String lastName) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void changeEmail(String email) {
    this.email = email;
  }
}

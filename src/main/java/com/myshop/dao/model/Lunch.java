package com.myshop.dao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lunch")
public class Lunch implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "LUNCH_NAME")
  private String lunchName;

  @Column(name = "LUNCH_RATE")
  private Integer lunchRate;

  @Column(name = "LUNCH_MEMO")
  private String lunchMemo;

  @Column(name = "LUNCH_TYPE")
  private String lunchType;

  @Column(name = "LUNCH_OWNER")
  private String lunchOwner;

  @Column(name = "LUNCH_ADD")
  private String lunchAdd;
}

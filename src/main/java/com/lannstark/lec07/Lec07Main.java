package com.lannstark.lec07;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Lec07Main {

  public static void main(String[] args) throws IOException {
    JavaFilePrinter printer = new JavaFilePrinter();
    printer.readFile("./a.txt");
  }

  private int parseIntoOrThrow(@NotNull String str) {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
    }
  }

  private Integer parseIntoOrThrow2(@NotNull String str) {
    try {
      return Integer.parseInt(str);
    } catch (NumberFormatException e) {
      return null;
    }
  }


}

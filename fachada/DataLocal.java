package fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataLocal {

	public static void main(String[] args) {
		LocalDate agora = LocalDate.now();
		System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}

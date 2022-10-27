package br.com.paulo25.EncLivro.util;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;



public class FormatadoraDeStringsDeDatas {
	
	public static String converterDatasString(String data){ 
		   

		  String dataConvertida = "";
			
		  try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy[-][MM][-][dd]");
				  TemporalAccessor dt = formatter.parseBest(data, LocalDate::from,
				  YearMonth::from, Year::from); 
				  
				
				  
				  if (dt instanceof Year) { Year ano = Year.from(dt); 
				  dataConvertida = ano.format(DateTimeFormatter.ofPattern("yyyy"));
				  
				  }
				  
				  if (dt instanceof YearMonth) { YearMonth mesAno = YearMonth.from(dt);
				  dataConvertida = mesAno.format(DateTimeFormatter.ofPattern("MM/yyyy"));
				  
				  }
				  
				  if (dt instanceof LocalDate) { LocalDate diaMesAno = LocalDate.from(dt);
				  dataConvertida = diaMesAno.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				  }
				  
			} catch (DateTimeParseException e) {
				System.out.println(e.getLocalizedMessage());;
				 return "data não disponível"; 
				
			}
		  
		 
		  return dataConvertida;
			  
			  
		
		 
	}

	
	/*
	 * public static String converterDatasString(String data) { DateTimeFormatter
	 * formatter = DateTimeFormatter.ofPattern("yyyy[-][MM][-][dd]");
	 * TemporalAccessor dt = formatter.parseBest(data, LocalDate::from,
	 * YearMonth::from, Year::from); String dataConvertida = "";
	 * 
	 * if (dt instanceof Year) { String year =
	 * String.valueOf(dt.get(ChronoField.YEAR)); dataConvertida = year; }
	 * 
	 * if (dt instanceof YearMonth) { String year =
	 * String.valueOf(dt.get(ChronoField.YEAR)); String month =
	 * String.valueOf(dt.get(ChronoField.MONTH_OF_YEAR)); dataConvertida =
	 * String.join("/", month, year); }
	 * 
	 * if (dt instanceof LocalDate) { String year =
	 * String.valueOf(dt.get(ChronoField.YEAR)); String month =
	 * String.valueOf(dt.get(ChronoField.MONTH_OF_YEAR)); String day =
	 * String.valueOf(dt.get(ChronoField.DAY_OF_MONTH)); dataConvertida =
	 * String.join("/",day, month, year); }
	 * 
	 * 
	 * return dataConvertida; }
	 */
	
	
}



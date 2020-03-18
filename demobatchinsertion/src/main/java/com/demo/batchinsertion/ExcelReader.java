package com.demo.batchinsertion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.demo.batchinsertion.entity.Employee;

public class ExcelReader {
	public List<Employee> readFromEmployeeSheet(String excelFilePath) throws IOException{
		    List<Employee> empList = new ArrayList<>();
		    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		 
		    Workbook workbook = new XSSFWorkbook(inputStream);
		    Sheet firstSheet = workbook.getSheetAt(0);
		    Iterator<Row> iterator = firstSheet.iterator();
		    
		   iterator.next();
		 
		    while (iterator.hasNext()) {
		        Row nextRow = iterator.next();
		        Iterator<Cell> cellIterator = nextRow.cellIterator();
		        Employee emp = new Employee();
		 
		        while (cellIterator.hasNext()) {
		            Cell nextCell = cellIterator.next();
		            int columnIndex = nextCell.getColumnIndex();
		 
		            switch (columnIndex) {
		            case 0:
		            	emp.setSlNo((int)nextCell.getNumericCellValue());
		                break;
		            case 1:
		            	emp.setName(nextCell.getStringCellValue());
		                break;
		            case 2:
		            	emp.setAge((int)nextCell.getNumericCellValue());
		                break;
		            
		        	case 3:
		        		emp.setGender(nextCell.getStringCellValue());
		        		break;
	            	
		    		case 4:
		    			emp.setSalary((int)nextCell.getNumericCellValue());
		    			break;
            		
		 
		 
		        }
		           
		    }
		        empList.add(emp);
		    workbook.close();
		    inputStream.close();
		 
		   
		}
		    return empList;
	}
	
//	private Object getCellValue(Cell cell) {
//	    switch (cell.getCellType()) {
//	    case Cell.CELL_TYPE_STRING:
//	        return cell.getStringCellValue();
//	 
//	    case Cell.CELL_TYPE_NUMERIC:
//	        return cell.getNumericCellValue();
//	    }
//	 
//	    return null;
//	}

	}


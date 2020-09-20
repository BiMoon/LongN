package TestDemo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
public class ReadTC {
	static HSSFRow row;
	static String run_yes;
	static String result;  
	static String dirpath = "src//main//resources//";
	public static String getTestcaseName(String tc) throws IOException{
	       FileInputStream inputStream = new FileInputStream(new File(dirpath + "Test_case.xls"));
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	       HSSFSheet sheet = workbook.getSheet("Testcase");
	       Iterator<Row> rowIterator = sheet.iterator();
	       
           while (rowIterator.hasNext()) 
           {
               row = (HSSFRow)rowIterator.next();
               
               Iterator < Cell >  cellIterator = row.cellIterator();
               
               while ( cellIterator.hasNext()) 
               {
                  Cell cell = cellIterator.next();
                  String run = cell.getStringCellValue();
                  //System.out.println(run);
                  if (run.equals(tc)) 
                  {
                	  //System.out.println(workbook.getSheetAt(0).getRow(cell.getRowIndex()).getCell(cell.getColumnIndex() -1));
                	  run_yes = workbook.getSheetAt(0).getRow(cell.getRowIndex()).getCell(cell.getColumnIndex()+1).getStringCellValue();
        
                  }
               }
           }
        
		return run_yes;
	}
	
	public static String getTestcase_report(String tc, String build_id) throws IOException{
		FileInputStream inputStream = new FileInputStream(new File(dirpath + "Test_report.xls"));
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	       HSSFSheet sheet = workbook.getSheet(build_id);
	       Iterator<Row> rowIterator = sheet.iterator();
	       String result = null;
	       
	           while (rowIterator.hasNext()) {
	        	   row = (HSSFRow)rowIterator.next();
	        	   Iterator < Cell >  cellIterator = row.cellIterator();
	        	    
	        	   while ( cellIterator.hasNext()) 
	        	   {
	        		   Cell cell = cellIterator.next();
	        		   
	        		   String run = cell.getStringCellValue();
	        		   //System.out.println(run);
	        		   
		        		   if (run.equals(tc)) {

		        			  try {
		        				  
		        				  result = sheet.getRow(cell.getRowIndex()).getCell(cell.getColumnIndex()+1).getStringCellValue();
		        				  
		        			  }
		        			  
		        			 catch (NullPointerException e) {
		        		    		   System.out.println("HAVE NOT REPORT FOR THIS TEST CASE YET");
		        		    	   }
	        		     }
	        		
	             }
	        }
		    
    	   
          if (result == null)
          {
        	  return "null";
          }
	           
          else 
          {
        	  return result;
          }
	}
	
	public static void updateTestcaseName(String tc) throws IOException{
		   FileInputStream inputStream = new FileInputStream(new File(dirpath + "Test_case.xls"));
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	       HSSFSheet sheet = workbook.getSheet("Testcase");
	       Iterator<Row> rowIterator = sheet.iterator();
	       boolean update_testcase = true;
	       int last_row = sheet.getLastRowNum();
	       int col = 0;
	       
	       while (rowIterator.hasNext()) 
	       {
	         row = (HSSFRow)rowIterator.next();
	       
	         Iterator < Cell >  cellIterator = row.cellIterator();
	          while (( cellIterator.hasNext()) && (update_testcase==true)) 
	          {
               Cell cell = cellIterator.next();
               String run = cell.getStringCellValue();
               
               if (run.equals(tc)) 
               {
             	  System.out.println("Already have this case ...");
             	  //testcaseName = workbook.getSheetAt(0).getRow(cell.getRowIndex()).getCell(cell.getColumnIndex()+1).getStringCellValue();
             	  update_testcase = false;
            	  break;
               }
               col ++;
               
	        	  if ((col > last_row) && (update_testcase == true))
	        	  {
	        		  //System.out.println(" NEED TO ADD TEST CASE TO TESTCASE SHEET" + col + "  " +last_row);
	        		  //update_testcase = true;
	        	  }
             
            }
        }
        
       if (update_testcase == true) 
       {
    	   System.out.println("This case is not added ...adding");
    	   HSSFRow row;
    	   
    	   row = sheet.createRow(last_row +1);
    	   
    	   Cell cell = row.createCell(0);
    	   
    	   cell.setCellValue(tc);
    	   
    	   Cell cell_run = row.createCell(1);
    	   
    	   cell_run.setCellValue("Y");
    	   
    	   File file_write = new File(dirpath + "Test_case.xls");
    	   
           FileOutputStream outFile = new FileOutputStream(file_write);
           
           workbook.write(outFile);
           outFile.close();
           //System.out.println("DONE");
      }
	}

	public static void createTestReport(String build_id) throws IOException{
		boolean build_sheet = false; 
		//String dirpath = "src//main//resources//";
		 
		File f1 = new File(dirpath +"Test_report.xls");
		
		if (f1.exists() == true) {System.out.println("Report file is already");}
		
		else 
		{
			OutputStream report_f = new FileOutputStream(dirpath +"Test_report.xls");
			report_f.close();
			System.out.println("Report file is created");
			
		}
		
		FileInputStream inputStream = new FileInputStream(new File(dirpath +"Test_report.xls"));
		HSSFWorkbook workbook_rp = new HSSFWorkbook(inputStream);
		//search sheet buidl_id in wb
		int nrSheets = workbook_rp.getNumberOfSheets();
		String[] names = new String[nrSheets];
		for ( int i = 0; i < nrSheets; i++ ) 
		{
			names[i] = workbook_rp.getSheetName( i );
			if (names[i].equals(build_id)){build_sheet = true; break;}
				//System.out.print(names[i]);
		 }
		
		if (build_sheet != true ) 
		{ 
			System.out.println("Need to create build sheet");
			HSSFSheet sheet = workbook_rp.createSheet(build_id);
			FileOutputStream outFile = new FileOutputStream(f1);
	        workbook_rp.write(outFile);
	        outFile.close();
	        System.out.println("Build sheet has been created");
		}
		// set value for Cell 0 "Test case" & cell 1 "Result" 
		HSSFSheet sheet = workbook_rp.getSheet(build_id);
		HSSFRow row;
		
 	    row = sheet.createRow(0);
 	    
 	    Cell cell = row.createCell(0);
 	    
 	    cell.setCellValue("Test case");
 	    
 	    Cell cell_run = row.createCell(1);
 	    
 	    cell_run.setCellValue("Result");
 	    
 	    File file_write = new File(dirpath + "Test_report.xls");
 	    
        FileOutputStream outFile = new FileOutputStream(file_write);
        workbook_rp.write(outFile);
        outFile.close();
        System.out.println("DONE");
		
	}
		
	public static void updateTestReport(String tc, String result, String build_id) throws IOException{
		   FileInputStream inputStream = new FileInputStream(new File(dirpath + "Test_report.xls"));
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	       HSSFSheet sheet = workbook.getSheet(build_id);
	       Iterator<Row> rowIterator = sheet.iterator();
	       boolean update_testcase = true;
	       int last_row = sheet.getLastRowNum();
	       int col = 0;
	       //System.out.print(build_id);
	       
	       while (rowIterator.hasNext()) 
	       {
	         row = (HSSFRow)rowIterator.next();
	         //System.out.print(n++);
	         Iterator < Cell >  cellIterator = row.cellIterator();
	          while (( cellIterator.hasNext()) && (update_testcase==true)) 
	          {
	        	  
	        	  Cell cell = cellIterator.next();
	        	  String run = cell.getStringCellValue();
	        	  if (run.equals(tc)) 
	        	  {
	        		  //System.out.println("Already have this case ...");
	        		  // Found test case name, update test result for tested case here
	        		  Cell cell_result = row.createCell(1);
	        		  
	        		  //System.out.println("Already have this case ...at cell: " + cell.getRowIndex());
	        		  
	   	    	      cell_result.setCellValue(result);
	   	    	      
	   	    	      File file_write = new File("src//main//resources//Test_report.xls");
	   	    	      
	   	    	      FileOutputStream outFile = new FileOutputStream(file_write);
	   	    	      
	   	    	      workbook.write(outFile);
	   	    	      outFile.close();
	   	    	      //System.out.println("RESULT IS UPDATED DONE");
	        		  //testcaseName = workbook.getSheetAt(0).getRow(cell.getRowIndex()).getCell(cell.getColumnIndex()+1).getStringCellValue();
	        		  update_testcase = false;
	        		  break;
	        	
	              }
	        	  
	        	  col ++;
	        	  if ((col > last_row) && (update_testcase == true))
	        	  {
	        		  //System.out.println(" NEED TO ADD TEST CASE TO REPORT SHEET" + col + "  " +last_row);
	        		  //update_testcase = true;
	        	  }
	         }
	         
	       }
	       
	       if (update_testcase == true) 
	       {
	    	   //System.out.println("This case is not added ...adding");
	    	   System.out.println("TEST CASE NAME NOT ESXIT YET ");
	    	   HSSFRow row;
	    	   row = sheet.createRow(last_row +1);
	    	   
	    	   Cell cell = row.createCell(0);
	    	   
	    	   cell.setCellValue(tc);
	    	   
	    	   Cell cell_run = row.createCell(1);
	    	   
	    	   cell_run.setCellValue(result);
	    	   
	    	   File file_write = new File(dirpath + "Test_report.xls");
	           FileOutputStream outFile = new FileOutputStream(file_write);
	           workbook.write(outFile);
	           outFile.close();
	           System.out.println("DONE");
	     }
	}
	public static void main(String[] agrs) throws IOException {
		/**
		String tc_name_test = "TestInvalidGmail_FFF";
		String yes = getTestcase_report("CareerBuilderTestLoginFirefox_new", "0102030405");
		System.out.println(yes);
		if (null!=yes){System.out.println("Already have");}
		
		//else {updateTestcaseName(tc_name_test);}
		
		//createTestReport("1234ee");
		//updateTestReport("abcssses", "PASSED", "567");
		}
		**/
	}
}
	

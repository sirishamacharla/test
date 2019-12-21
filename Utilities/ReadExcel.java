package Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadExcel  {
Workbook wb;
FileOutputStream fo;
//to read excel path write constructor
public ReadExcel(String excelpath)throws Throwable
{
FileInputStream fi=new FileInputStream(excelpath);
wb=WorkbookFactory.create(fi);
}
//count no of rows in sheet
public int rowCount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
}
//count no of columns in row
public int colCount(String sheetname)
{
	return wb.getSheet(sheetname).getRow(0).getLastCellNum();
}
//get cell data
public String getCellData(String sheetname,int row,int column)
{
	String data="";
if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
{
//get numeric cell data
int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
//convert int to string 
data=String.valueOf(celldata);
}
else
{
data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();	
}
return data;
}
//method for writing
public void SetData(String sheetname,int row,int column,String status,
		String writeexcel)throws Throwable
{
wb.getSheet(sheetname).getRow(row).createCell(column).setCellValue(status);	
fo=new FileOutputStream(writeexcel);
wb.write(fo);
}
//method to close files
public void closeFiles()throws Throwable
{
fo.close();	
wb.close();
}
//filling green colour
public void greencolour(String sheetname,int row,int column,String writeexcel)
throws Throwable{
Sheet ws=wb.getSheet(sheetname);
CellStyle style =wb.createCellStyle();
Font font=wb.createFont();
style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//Apply Bold To The Text
font.setBoldweight(Font.BOLDWEIGHT_BOLD);
style.setFont(font);
ws.getRow(row).getCell(column).setCellStyle(style);
fo=new FileOutputStream(writeexcel);
wb.write(fo);
}
//filling green colour
public void redcolour(String sheetname,int row,int column,String writeexcel)
throws Throwable{
Sheet ws=wb.getSheet(sheetname);
CellStyle style =wb.createCellStyle();
Font font=wb.createFont();
style.setFillForegroundColor(IndexedColors.RED.getIndex());
style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//Apply Bold To The Text
font.setBoldweight(Font.BOLDWEIGHT_BOLD);
style.setFont(font);
ws.getRow(row).getCell(column).setCellStyle(style);
fo=new FileOutputStream(writeexcel);
wb.write(fo);
}
}














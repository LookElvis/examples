package Project.Yunzhen;

/**
 * Created by Elvis on 2020/7/31.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2Mysql {

    public static void main(String[] args) {
        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        String filePath = "C:\\Users\\廿半\\Desktop\\yunzhen.xlsx";
        String columns[] = {"shape", "productid", "certificate", "weight", "purity", "color", "cut", "polish", "symmetric", "fluorescence", "price"};
        wb = readExcel(filePath);
        if (wb != null) {
            //用来存放表中数据
            list = new ArrayList<Map<String, String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            //获得列名
//            for (int i = 0; i < colnum; i++) {
//                System.out.println(row.getCell(i));
//            }
            for (int i = 1; i < rownum; i++) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < colnum; j++) {
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                    }
                } else {
                    break;
                }
                list.add(map);
            }
        }
        //遍历解析出来的list
        StringBuilder sb = new StringBuilder();
        for (Map<String, String> map : list) {
            String sql = "INSERT INTO t_diamond (shape, productid, certificate, weight, purity, color, cut, polish, symmetric, fluorescence, price) VALUES (";
            int size = map.size();
            int count = 0;
            for (Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals("圆形")) {
                    sql += "\"zuan01\"";
                } else {
//                    sql += "`" + entry.getValue() + "`";
                    if (entry.getKey().equals("productid")) {
                        sql += new Double(Double.parseDouble(entry.getValue())).intValue();
                    } else if (entry.getKey().equals("weight") || entry.getKey().equals("price")) {
                        sql += entry.getValue();
                    } else {
                        sql += "\"" + entry.getValue() + "\"";
                    }
                }
                if (count != size - 1) {
                    sql += ",";
                }
                count++;
            }
            sql += ");";
            sb.append(sql + "\n");
//            System.out.println(sql);
        }
        System.out.println(sb.toString());
        //写入文件
        String writePath = "C:\\Users\\廿半\\Desktop\\mysql.txt";
        writeFile(writePath, sb.toString());
    }

    //写入文件
    public static void writeFile(String path, String content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            //使用true，即进行append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            fileWritter.write(content);
            fileWritter.close();
            System.out.println("finish");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

}

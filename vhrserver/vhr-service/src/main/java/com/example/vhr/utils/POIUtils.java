package com.example.vhr.utils;

import com.example.vhr.model.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POIUtils {
    public static ResponseEntity<byte[]> employee2Excel(List<Employee> list) {
        //1.创建excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建文档摘要
        workbook.createInformationProperties();
        //3.获取并配置文章摘要信息
        DocumentSummaryInformation documentSummaryInformation = workbook.getDocumentSummaryInformation();
        documentSummaryInformation.setCategory("员工信息");
        documentSummaryInformation.setManager("javaboy");
        documentSummaryInformation.setCompany("南邮");
        //4.获取文档摘要信息
        SummaryInformation summaryInformation = workbook.getSummaryInformation();
        summaryInformation.setTitle("员工信息表");
        summaryInformation.setAuthor("w");
        summaryInformation.setComments("由谁提供");

        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        sheet.setColumnWidth(0 ,5*256);
        sheet.setColumnWidth(1 ,12*256);
        sheet.setColumnWidth(2 ,10*256);
        sheet.setColumnWidth(3 ,5*256);
        sheet.setColumnWidth(4 ,12*256);
        sheet.setColumnWidth(5 ,20*256);
        sheet.setColumnWidth(6 ,10*256);
        sheet.setColumnWidth(7 ,10*256);
        sheet.setColumnWidth(8 ,16*256);
        sheet.setColumnWidth(9 ,12*256);
        sheet.setColumnWidth(10,15*256);
        sheet.setColumnWidth(11,20*256);
        sheet.setColumnWidth(12,20*256);
        sheet.setColumnWidth(13,16*256);
        sheet.setColumnWidth(14,15*256);
        sheet.setColumnWidth(15,12*256);
        sheet.setColumnWidth(16,10*256);
        sheet.setColumnWidth(17,20*256);
        sheet.setColumnWidth(18,20*256);
        sheet.setColumnWidth(19,20*256);
        sheet.setColumnWidth(20,16*256);
        sheet.setColumnWidth(21,25*256);
        sheet.setColumnWidth(22,15*256);
        sheet.setColumnWidth(23,16*256);
        sheet.setColumnWidth(24,16*256);

        //创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        HSSFCell c1 = r0.createCell(1);
        HSSFCell c2 = r0.createCell(2);
        HSSFCell c3 = r0.createCell(3);
        HSSFCell c4 = r0.createCell(4);
        HSSFCell c5 = r0.createCell(5);
        HSSFCell c6 = r0.createCell(6);
        HSSFCell c7 = r0.createCell(7);
        HSSFCell c8 = r0.createCell(8);
        HSSFCell c9 = r0.createCell(9);
        HSSFCell c10 = r0.createCell(10);
        HSSFCell c11 = r0.createCell(11);
        HSSFCell c12 = r0.createCell(12);
        HSSFCell c13 = r0.createCell(13);
        HSSFCell c14 = r0.createCell(14);
        HSSFCell c15 = r0.createCell(15);
        HSSFCell c16 = r0.createCell(16);
        HSSFCell c17 = r0.createCell(17);
        HSSFCell c18 = r0.createCell(18);
        HSSFCell c19 = r0.createCell(19);
        HSSFCell c20 = r0.createCell(20);
        HSSFCell c21 = r0.createCell(21);
        HSSFCell c22 = r0.createCell(22);
        HSSFCell c23 = r0.createCell(23);
        HSSFCell c24 = r0.createCell(24);
        c0.setCellValue("编号");
        c1.setCellValue("姓名");
        c2.setCellValue("工号");
        c3.setCellValue("性别");
        c4.setCellValue("出生日期");
        c5.setCellValue("身份证号码");
        c6.setCellValue("婚姻状况");
        c7.setCellValue("民族");
        c8.setCellValue("籍贯");
        c9.setCellValue("政治面貌");
        c10.setCellValue("电话号码");
        c11.setCellValue("联系地址");
        c12.setCellValue("所属部门");
        c13.setCellValue("职称");
        c14.setCellValue("职位");
        c15.setCellValue("聘用形式");
        c16.setCellValue("最高学历");
        c17.setCellValue("专业");
        c18.setCellValue("毕业院校");
        c19.setCellValue("入职日期");
        c20.setCellValue("在职状态");
        c21.setCellValue("邮箱");
        c22.setCellValue("合同期限");
        c23.setCellValue("合同起始日期");
        c24.setCellValue("合同终止日期");

        //遍历list集合，放数据
        int i=1;
        for (Employee employee : list) {
            HSSFRow row = sheet.createRow(i);
            i++;
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getWorkid());
            row.createCell(3).setCellValue(employee.getGender());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dateCellStyle);
            cell4.setCellValue(employee.getBirthday());
            row.createCell(5).setCellValue(employee.getIdcard());
            row.createCell(6).setCellValue(employee.getWedlock());
            row.createCell(7).setCellValue(employee.getNation().getName());
            row.createCell(8).setCellValue(employee.getNativeplace());
            row.createCell(9).setCellValue(employee.getPoliticsstatus().getName());
            row.createCell(10).setCellValue(employee.getPhone());
            row.createCell(11).setCellValue(employee.getAddress());
            row.createCell(12).setCellValue(employee.getDepartment().getName());
            row.createCell(13).setCellValue(employee.getjObLevel().getName());
            row.createCell(14).setCellValue(employee.getPosition().getName());
            row.createCell(15).setCellValue(employee.getEngageform());
            row.createCell(16).setCellValue(employee.getTiptopdegree());
            row.createCell(17).setCellValue(employee.getSpecialty());
            row.createCell(18).setCellValue(employee.getSchool());
            HSSFCell cell19 = row.createCell(19);
            cell19.setCellStyle(dateCellStyle);
            cell19.setCellValue(employee.getBegindate());
            row.createCell(20).setCellValue(employee.getWorkstate());
            row.createCell(21).setCellValue(employee.getEmail());
            row.createCell(22).setCellValue(employee.getContractterm());
            HSSFCell cell23 = row.createCell(23);
            cell23.setCellStyle(dateCellStyle);
            cell23.setCellValue(employee.getBegincontract());
            HSSFCell cell24 = row.createCell(24);
            cell24.setCellStyle(dateCellStyle);
            cell24.setCellValue(employee.getEndcontract());
            HSSFCell cell25 = row.createCell(25);
            cell25.setCellStyle(dateCellStyle);
            cell25.setCellValue(employee.getConversiontime());

        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HttpHeaders headers=new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工表.xls"
                    .getBytes("UTF-8"),"ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<byte[]>(outputStream.toByteArray(),headers,HttpStatus.CREATED);
    }

    public static List<Employee> excel2Employee(MultipartFile file, List<Nation> allNations,
                                                List<Politicsstatus> allPoliticsstatus,
                                                List<Department> allDepertment, List<Position> allPositions,
                                                List<JObLevel> allJobLevels) throws IOException {
        List<Employee> list = new ArrayList<>();
        Employee employee =null;
        //创建一个workbook对象
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        //获取表单
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            //获取表单中的行数
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            for (int i1 = 0; i1 < physicalNumberOfRows; i1++) {
                //跳过标题行
                if(i1==0){
                    continue;
                }
                //获取行
                HSSFRow row = sheet.getRow(i1);
                //防止中间有空行
                if(row==null){
                    continue;
                }
                //获取列
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                employee= new Employee();
                for (int i2 = 0; i2 < physicalNumberOfCells; i2++) {
                    HSSFCell cell = row.getCell(i2);
                    switch (cell.getCellType()){
                        case STRING:{
                            String stringCellValue = cell.getStringCellValue();
                            switch (i2){
                                case 1:
                                    employee.setName(stringCellValue);
                                    break;
                                case 2:
                                    employee.setWorkid(stringCellValue);
                                    break;
                                case 3:
                                    employee.setGender(stringCellValue);
                                    break;
                                case 5:
                                    employee.setIdcard(stringCellValue);
                                    break;
                                case 6:
                                    employee.setWedlock(stringCellValue);
                                    break;
                                case 7:
                                    int nationIndex = allNations.indexOf(new Nation(stringCellValue));
                                    employee.setNationid(allNations.get(nationIndex).getId());
                                    break;
                                case 8:
                                    employee.setNativeplace(stringCellValue);
                                    break;
                                case 9:
                                    int index = allPoliticsstatus.indexOf(new Politicsstatus(stringCellValue));
                                    employee.setPoliticid(allPoliticsstatus.get(index).getId());
                                    break;
                                case 10:
                                    employee.setPhone(stringCellValue);
                                    break;
                                case 11:
                                    employee.setAddress(stringCellValue);
                                    break;
                                case 12:
                                    int index1 = allDepertment.indexOf(new Department(stringCellValue));
                                    employee.setDepartmentid(allDepertment.get(index1).getId());
                                    break;
                                case 13:
                                    int index2 = allJobLevels.indexOf(new JObLevel(stringCellValue));
                                    employee.setJoblevelid(allJobLevels.get(index2).getId());
                                    break;
                                case 14:
                                    int index3 = allPositions.indexOf(new Position(stringCellValue));
                                    employee.setPosid(allPositions.get(index3).getId());
                                    break;
                                case 15:
                                    employee.setEngageform(stringCellValue);
                                    break;
                                case 16:
                                    employee.setTiptopdegree(stringCellValue);
                                    break;
                                case 17:
                                    employee.setSpecialty(stringCellValue);
                                    break;
                                case 18:
                                    employee.setSchool(stringCellValue);
                                    break;
                                case 20:
                                    employee.setWorkstate(stringCellValue);
                                    break;
                                case 21:
                                    employee.setEmail(stringCellValue);
                                    break;
                            }
                            break;
                        }
                        default:{
                            switch (i2){
                                case 4:
                                    employee.setBirthday(cell.getDateCellValue());
                                    break;
                                case 19:
                                    employee.setBegindate(cell.getDateCellValue());
                                    break;
                                case 23:
                                    employee.setBegincontract(cell.getDateCellValue());
                                    break;
                                case 24:
                                    employee.setEndcontract(cell.getDateCellValue());
                                    break;
                                case 22:
                                    employee.setContractterm(cell.getNumericCellValue());
                                    break;
                                case 2:
                                    employee.setConversiontime(cell.getDateCellValue());
                                    break;
                            }
                            break;
                        }
                    }

                }
                list.add(employee);
            }

        }

        return list;
    }
}

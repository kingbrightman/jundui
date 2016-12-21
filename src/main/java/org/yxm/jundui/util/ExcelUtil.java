package org.yxm.jundui.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;
import org.yxm.jundui.model.User;
import org.yxm.jundui.web.dto.TrainSubjectGradesDto;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by yxm on 2016.12.21.
 */
public class ExcelUtil {

    public static void demo(HttpServletResponse response, List<User> userList) throws IOException {
        HSSFWorkbook wb;
        // 配置明细表需要显示的字段
        String[] headers = {"用户@id", "类型@type.name", "服役@active", "团体@group.name", "用户名@username", "密码@password",
                "名字@name", "日期@createDate"};

        try {
            wb = PoiExcelUtils.createExcel2Export("用户表", "用户表", headers,
                    userList);
        } catch (Exception e) {
            throw new RuntimeException("生成Excel表格数据失败");
        }

        FileOutputStream output = new FileOutputStream("d:\\" + ProDateUtil.getCurrentDateFileName(ProDateUtil.DATE_TIME_FORMAT) + ".xls");
        wb.write(output);
        output.flush();

//        OutputStream output=response.getOutputStream();
//        response.reset();
//        response.setHeader("Content-disposition", "attachment; filename=details.xls");
//        response.setContentType("application/msexcel");
//        wb.write(output);
//        output.flush();
    }

    public static void exportTrainExcel(List<TrainSubjectGradesDto> grades, HttpServletResponse response) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();

        String[] headers = {"用户@user.name", "成绩@content", "分数@score"};

        for (TrainSubjectGradesDto g : grades) {
            try {
                PoiExcelUtils.createExcel2Export(wb, g.subject.getName(),
                        g.train.getName() + "-" + g.subject.getName(),
                        headers, g.grades);
            } catch (Exception e) {
                throw new RuntimeException("生成Excel表格数据失败");
            }
        }

        exportWorkbook(response, wb);
    }

    protected static void writeWorkbook(HttpServletResponse response, HSSFWorkbook workbook) {
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String fileName = System.currentTimeMillis() + ".xls";
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
            workbook.close();
        } catch (Exception e) {
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    protected static void exportWorkbook(HttpServletResponse response, HSSFWorkbook workbook) throws IOException {
        OutputStream output = response.getOutputStream();
        String fileName = ProDateUtil.getCurrentDateFileName(ProDateUtil.DATE_TIME_FORMAT) + ".xls";
        response.reset();
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".xls");
        workbook.write(output);
        output.close();
        output.flush();
    }
}

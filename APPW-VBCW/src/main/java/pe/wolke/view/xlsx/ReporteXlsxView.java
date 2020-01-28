package pe.wolke.view.xlsx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import pe.wolke.model.entity.Boleto;

@Component("reportes")
public class ReporteXlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Collection<Boleto> boletos = (Collection<Boleto>)model.get("Boletos");
		Sheet sheet = workbook.createSheet();
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		
		cell.setCellValue("Reporte de los boletos");
		
		Row header = sheet.createRow(2);
		
		header.createCell(0).setCellValue("Id");
		header.createCell(1).setCellValue("Cliente");
		header.createCell(2).setCellValue("Pelicula");
		header.createCell(3).setCellValue("Calidad");
		header.createCell(4).setCellValue("Fecha");
		header.createCell(5).setCellValue("Cant. Butacas");
		header.createCell(6).setCellValue("Monto Final");
		
		int rowNum = 3;
		Double recaudado = 0.0;
		
		for(Boleto boleto: boletos) {
			Row fila = sheet.createRow(rowNum++);
			
			fila.createCell(0).setCellValue(boleto.getId());
			fila.createCell(1).setCellValue(boleto.getCliente().getNombres() + boleto.getCliente().getApellidos());
			fila.createCell(2).setCellValue(boleto.getProyeccion().getPelicula().getTitulo());
			fila.createCell(3).setCellValue(boleto.getProyeccion().getCalidad());
			fila.createCell(4).setCellValue(boleto.getFecha());
			fila.createCell(5).setCellValue(boleto.getItemsReservaButaca().size());
			fila.createCell(6).setCellValue(boleto.getMonto_final());
			recaudado = recaudado + boleto.getMonto_final();
		}
		
		Row filaToral = sheet.createRow(rowNum);
		filaToral.createCell(5).setCellValue("Recaudado");
		filaToral.createCell(6).setCellValue(recaudado);		
		
	}

	
	
}

use bd_cinewolke;

-- butacas unique constraint
ALTER TABLE butacas
ADD UNIQUE (id_sala, fila, columna);

-- proyecciones unique constraint
ALTER TABLE proyecciones
ADD UNIQUE (id_sala, fecha, hora);

-- tarifas unique constraint
ALTER TABLE tarifas
ADD UNIQUE (tipo_cliente, calidad);

-- detalle_boleto unique constraint
ALTER TABLE detalle_boleto
ADD UNIQUE (id_boleto, id_tarifa);

--  unique constraint
ALTER TABLE detalle_boleto
ADD UNIQUE (id_boleto, id_tarifa);


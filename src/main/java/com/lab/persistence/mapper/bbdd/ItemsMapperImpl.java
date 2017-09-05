package com.lab.persistence.mapper.bbdd;
import com.lab.persistence.model.ItemsModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ItemsMapperImpl implements ItemsMapper
{

  @Autowired
  BBDD db;


  @Override
  public List<ItemsModel> testMapper(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = new ArrayList<>();

    /**
     * CONECTANDO A LA BBDD.
     */
    db.conecta();

    String sql = "SELECT * FROM items where (nombre LIKE '%" + obj.getNombre() + "%')";

    ResultSet rs = db.consulta(sql);
    while (rs.next())
    {
      ItemsModel item = new ItemsModel();

      item.setId(rs.getInt("id"));
      item.setNombre(rs.getString("nombre"));
      item.setDescripcion(rs.getString("descripcion"));
      item.setUrl(rs.getString("url"));

      x.add(item);
    }
    /**
     * DESCONECTANDO A LA BBDD.
     */
    db.desconecta();

    return x;
  }
  
    @Override
  public List<ItemsModel> allItemMapper(ItemsModel obj) throws Exception
  {
    List<ItemsModel> y = new ArrayList<>();

    /**
     * CONECTANDO A LA BBDD.
     */
    db.conecta();

    String sql = "SELECT * FROM items";

    ResultSet rs = db.consulta(sql);
    while (rs.next())
    {
      ItemsModel item = new ItemsModel();

      item.setId(rs.getInt("id"));
      item.setNombre(rs.getString("nombre"));
      item.setDescripcion(rs.getString("descripcion"));
      item.setUrl(rs.getString("url"));

      y.add(item);
    }
    /**
     * DESCONECTANDO A LA BBDD.
     */
    db.desconecta();

    return y;
  }


}

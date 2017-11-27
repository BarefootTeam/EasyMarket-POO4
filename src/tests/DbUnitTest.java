package tests;
import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

public class DbUnitTest {

	protected IDataSet getDataSet() throws Exception {
		FileInputStream file = new FileInputStream("src/tests/dataset.xml");
		return new FlatXmlDataSetBuilder().build(file);
	}

	@Before
	public void importDataSet() throws Exception {
		IDataSet dataSet = getDataSet();
		cleanlyInsertDataset(dataSet);
	}

	private void cleanlyInsertDataset(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester("org.postgresql.Driver",
				"jdbc:postgresql://localhost:5432/easymarket", "postgres", "masterkey");
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	// Cliente Begin
	
	@Test
    public void testaTabelaCliente() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("cliente").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaClienteQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("cliente").getTableMetaData().getColumns().length;
          assertTrue(colCount==7);   
    }
	
	@Test
    public void testaTabelaClienteValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("cliente").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	// Cliente End
	
	// Usuario Begin
	
	@Test
    public void testaTabelaUsuario() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("usuario").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaUsuarioQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("usuario").getTableMetaData().getColumns().length;
          assertTrue(colCount==8);   
    }
	
	@Test
    public void testaTabelaUsuarioValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("usuario").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	// Usuario End
	
	// Produto Begin
	
	@Test
    public void testaTabelaProduto() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("produto").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaProdutoQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("produto").getTableMetaData().getColumns().length;
          assertTrue(colCount==7);   
    }
	
	@Test
    public void testaTabelaProdutoValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("produto").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaProdutoValorColunaIDUsuario() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("produto").getValue(0, "usuario_id");
          assertTrue(colValue.equals("1001"));   
    }	
				
	// Produto End
	
	// Compra Begin
	
	@Test
    public void testaTabelaCompra() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("compra").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaCompraQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("compra").getTableMetaData().getColumns().length;
          assertTrue(colCount==3);   
    }
	
	@Test
    public void testaTabelaCompraValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("compra").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaCompraValorColunaIDUsuario() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("compra").getValue(0, "usuario_id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	// Compra End
	
	// Preco Begin
	
	@Test
    public void testaTabelaPreco() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("preco").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaPrecoQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("preco").getTableMetaData().getColumns().length;
          assertTrue(colCount==7);   
    }
	
	@Test
    public void testaTabelaPrecoValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("preco").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaPrecoValorColunaIDProduto() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("preco").getValue(0, "produto_id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaPrecoValorColunaIDUsuario() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("preco").getValue(0, "usuario_id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	// Preco End
	
	// Venda Begin
		
	@Test
    public void testaTabelaVenda() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("venda").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaVendaQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("venda").getTableMetaData().getColumns().length;
          assertTrue(colCount==4);   
    }
	
	@Test
    public void testaTabelaVendaValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("venda").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaVendaValorColunaIDCliente() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("venda").getValue(0, "cliente_id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaVendaValorColunaIDUsuario() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("venda").getValue(0, "usuario_id");
          assertTrue(colValue.equals("1001"));   
    }	
		
	// Venda End
		
	
	// ItemCompra Begin
	
	@Test
    public void testaTabelaItemCompra() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("item_compra").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaItemCompraQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("item_compra").getTableMetaData().getColumns().length;
          assertTrue(colCount==5);   
    }
	
	@Test
    public void testaTabelaItemCompraValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("item_compra").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaItemCompraColunaIDCompra() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("item_compra").getValue(0, "compra_id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaItemCompraValorColunaIDProduto() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("item_compra").getValue(0, "produto_id");
          assertTrue(colValue.equals("1001"));   
    }
	
	@Test
    public void testaTabelaItemCompraValorQtdItens() throws Exception{
		  assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("item_compra").getRowCount();
          assertTrue(rowCount==2);   
    }
	
	// ItemCompra End
	
	// ItemVenda Begin
	
	@Test
    public void testaTabelaItemVenda() throws Exception{
          assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("item_venda").getRowCount();
          assertTrue(rowCount!=0);   
     }
	
	@Test
    public void testaTabelaItemVendaQtdColunas() throws Exception{
          assertNotNull(getDataSet());
          int colCount = getDataSet().getTable("item_venda").getTableMetaData().getColumns().length;
          assertTrue(colCount==5);   
    }
	
	@Test
    public void testaTabelaItemVendaValorColunaID() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("item_venda").getValue(0, "id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaItemVendaColunaIDVenda() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("item_venda").getValue(0, "venda_id");
          assertTrue(colValue.equals("1001"));   
    }	
	
	@Test
    public void testaTabelaItemVendaValorColunaIDProduto() throws Exception{
          assertNotNull(getDataSet());
          String colValue = (String) getDataSet().getTable("item_venda").getValue(0, "produto_id");
          assertTrue(colValue.equals("1001"));   
    }
	
	@Test
    public void testaTabelaItemVendaValorQtdItens() throws Exception{
		  assertNotNull(getDataSet());
          int rowCount = getDataSet().getTable("item_venda").getRowCount();
          assertTrue(rowCount==2);   
    }
	
	// ItemVenda End
}

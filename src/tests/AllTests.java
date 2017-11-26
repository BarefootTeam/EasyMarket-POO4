package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ClienteDAOTest.class,
	ProdutoDAOTest.class, 	
	CompraDAOTest.class,
	ItemCompraDAOTest.class,
	VendaDAOTest.class,	
	ItemVendaDAOTest.class,
	PrecoDAOTest.class,	
	UsuarioDAOTest.class	
})

public class AllTests {

}

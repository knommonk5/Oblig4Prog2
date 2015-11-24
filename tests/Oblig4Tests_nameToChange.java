import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Oblig4Tests_nameToChange {
//navnPÂMetodeSomTestes_InputParametre_ForventetResultat()
	
	private String fBinary = "110101000000110111001101";
	private String sBinary = "001000011110011101001111";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void BinaryTilDeci_binary_burdeGiEnDesimal_NameToChange() {
		assertEquals(0, Utility.binToDecConv("00000000000000000000"));
		assertEquals(123456, Utility.binToDecConv("11110001001000000"));
		assertEquals(654321, Utility.binToDecConv("10011111101111110001"));
	}

}

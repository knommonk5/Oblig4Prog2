import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UtilityClassTests{
//navnPÂMetodeSomTestes_InputParametre_ForventetResultat()
	
	private String fBinary = "110101000000110111001101";
	private String sBinary = "001000011110011101001111";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void BinaryTilDeci_binary_burdeGiEnDesimal_NameToChange() {
		assertEquals(0, Utility.binToDecConv("0000000"));
		assertEquals(123456, Utility.binToDecConv("11110001001000000"));
		assertEquals(654321, Utility.binToDecConv("10011111101111110001"));
	}

	@Test( expected = IllegalArgumentException.class)
	public void BinaryTilDeci_binaryMedUlovligTegn_errorException_NameToChange() {
		Utility.binToDecConv("0008k0000");
	}
	@Test
	public void BinaryTilDeci_empty_zero_NameToChange() {
		assertEquals(0, Utility.binToDecConv(""));
	}
}

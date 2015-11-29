import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UtilityClassTests {
	// navnPÂMetodeSomTestes_InputParametre_ForventetResultat()

	private String fBinary = "110101000000110111001101";
	private String sBinary = "001000011110011101001111";
	private String uBinary = "00100U011110011101001111";
	private String lBinary = "0010000111100111010011110000";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void BinTilDeci_BinaryNr_BurdeGiEnDesimal() {
		assertEquals(0, Utility.binToDecConv("0000000"));
		assertEquals(123456, Utility.binToDecConv("11110001001000000"));
		assertEquals(654321, Utility.binToDecConv("10011111101111110001"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void BinTilDeci_BinaryMedUlovligTegn_SkalGiException() {
		Utility.binToDecConv("0008k0000");
	}

	@Test
	public void BinTilDeci_EmptyString_BurdeGiZero() {
		assertEquals(0, Utility.binToDecConv(""));
	}

	@Test
	public void DeciTilBin_NormalDeci_BurdeGiBinary() {
		assertEquals("000000000000000000000010", Utility.deciToBinConv(2));
		assertEquals("000000000000000001111011", Utility.deciToBinConv(123));
		assertEquals("000000000000001010001110", Utility.deciToBinConv(654));
	}

	@Test(expected = IllegalArgumentException.class)
	public void DeciTilBin_ForStorDeci_SkalGiException() {
		Utility.deciToBinConv(16777216);
	}

	/*
	 * @Test(expected = IllegalArgumentException.class) public void
	 * DeciTilBin_NegativDeci_SkalGiError() { Utility.deciToBinConv(-987); }
	 */

	@Test
	public void HexTilDeci_NormalHex_BurdeGiDeci() {
		assertEquals(17, Utility.hexToDeciConv("11"));
		assertEquals(852, Utility.hexToDeciConv("354"));
		assertEquals(0, Utility.hexToDeciConv("000000"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void HexTilDeci_ForStorHex_SkalGiException() {
		Utility.hexToDeciConv("3ADE68B1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void HexTilDeci_UlovligTegn_SkalGiException() {
		Utility.hexToDeciConv("123DAYUM");
	}


	@Test
	public void DeciTilHex_NormalDeci_BurdeGiVanligHex() {
		assertEquals(("00123F"), Utility.deciToHexConv(4671));
		assertEquals(("00001F"), Utility.deciToHexConv(31));
	}


	@Test public void BitwiseAND_NormalInput_Burdegi24BitUfall() {
		assertEquals(("0001"),Utility.bitwiseAnd("0001","0011"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void BitwiseAND_ForLangString_ThrowException() {
		Utility.bitwiseAnd(lBinary, sBinary);
	}

	@Test(expected = IllegalArgumentException.class)
	public void BitwiseAND_StringMedUlovlig_ThrowException() {
		Utility.bitwiseAnd(uBinary, sBinary);
	}

	@Test public void BitwiseOR_NormalInput_Burdegi24BitUfall() {
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void BitwiseOR__ForLangString_ThrowException() {
		Utility.bitwiseOR(lBinary, sBinary);
	}

	@Test(expected = IllegalArgumentException.class)
	public void BitwiseOR_StringMedUlovlig_ThrowException() {
		Utility.bitwiseOR(uBinary, sBinary);
	}
}

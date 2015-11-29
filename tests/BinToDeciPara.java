import static org.junit.Assert.assertEquals;

@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class BinToDeciPara {
	private String bin;
	private int deci;

	public BinToDeciPara(String bin, String deci) {
		this.bin = bin;
		this.deci = Integer.parseInt(deci);
	}

	@org.junit.runners.Parameterized.Parameters
	public static java.util.Collection<String[]> input() {
		return java.util.Arrays.asList(
				new String[][] { { "101111000110000101001110", "12345678" }, { "000000011110001001000000", "123456" },
						{ "000000000000010011010010", "1234" }, { "000000000000000000100001", "33" } });
	}

	@org.junit.Test
	public void testBinaryToDecConversion() {
		assertEquals((deci), Utility.binToDecConv(bin));
	}
}
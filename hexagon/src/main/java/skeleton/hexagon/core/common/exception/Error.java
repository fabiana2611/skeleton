package skeleton.hexagon.core.common.exception;

public class Error {

	public static void required(String nome) {
		throw new BusinessException(nome + " is required.");
	}

	public static void notFound(String nome) {
		throw new BusinessException(nome + " not found.");
	}

}

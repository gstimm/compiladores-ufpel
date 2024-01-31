import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

enum TokenType { NUM, SOMA, SUB, MULT, DIV, APar, FPar, EOF }

class Token {
	String lexema;
	TokenType token;

	Token (String l, TokenType t) {
		lexema = l;
		token = t;
	}

	Token (char l, TokenType t) {
		lexema = l + "";
		token = t;
	}
}

class AnaliseLexica {
	BufferedReader arquivo;
	char currchar;
	int currchar1;

	AnaliseLexica(String a) throws Exception {
	 	this.arquivo = new BufferedReader(new FileReader(a));
		getNextChar();
	}

	// Separei a função de leitura do próximo caractere em um método separado
	void getNextChar() throws IOException {
		do {
			currchar1 = arquivo.read();
			currchar = (char) currchar1;
		} while (currchar == '\n' || currchar == ' ' || currchar == '\t' || currchar == '\r');
  }

	Token getNextToken() throws Exception {	
		// Token token;
		int eof = -1;

		while (currchar1 != eof && currchar1 != 10) {
			if (Character.isDigit(currchar)) {
				// Se for um dígito, leia todos os dígitos consecutivos
				StringBuilder numLexema = new StringBuilder();

				while (Character.isDigit(currchar)) {
						numLexema.append(currchar);
						getNextChar();
				}

				return new Token(numLexema.toString(), TokenType.NUM);
			} else {
					switch (currchar) {
						case '(':
							getNextChar();
							return new Token ('(',TokenType.APar);
						case ')':
							getNextChar();
							return new Token (')',TokenType.FPar);
						case '+':
						getNextChar();
							return new Token ('+',TokenType.SOMA);
						case '-':
							getNextChar();
							return new Token ('-',TokenType.SUB);
						case '*':
							getNextChar();
							return new Token ('*',TokenType.MULT);
						case '/':
							getNextChar();
							return new Token ('/',TokenType.DIV);
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}
		}

		arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
	}
}

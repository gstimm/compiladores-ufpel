echo Iniciando a compilação do projeto
javac *.java;

echo TESTE COMPILADOR 
java Compilador teste

echo TESTE MAQUINA DE PILHA
java MaquinaPilha arquivoDeEntrada
java Lugosi example1.lug;

echo Removendo arquivos .class
rm -rf *.class

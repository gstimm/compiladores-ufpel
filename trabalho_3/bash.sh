echo Iniciando a compilação do projeto
javacc Lugosi.jj;
javac *.java;

echo TESTE 0
java Lugosi example.lug;

echo TESTE 1
java Lugosi example1.lug;

echo TESTE 2
java Lugosi example2.lug;

echo Removendo arquivos .java e .class
rm -rf *.java
rm -rf *.class
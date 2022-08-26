package main

import (
	"fmt"
)

func main() {

	nome := "thiago"
	versao := 1.1 // inferencia do nome var e tipo

	fmt.Println("Hello ", nome)
	fmt.Println("", versao)

	fmt.Println("1 - Iniciar Monitoramento")
	fmt.Println("2 - Exibir Logs")
	fmt.Println("0 - Sair do programa")

	var comando int
	//fmt.Scanf("%d", &comando)
	fmt.Scan(&comando)

	if comando == 1 {
		fmt.Println("Monitorando")
	} else if comando == 2 {
		fmt.Println("Exibindo logs")
	} else if comando == 0 {
		fmt.Println("Saindo do programa")
	} else {
		fmt.Println("Comando não reconhecido")
	}

}

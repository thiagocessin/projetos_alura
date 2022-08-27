package main

import (
	"fmt"
	"net/http"
	"os"
)

func main() {

	exibeIntroducao()
	for {
		exibeMenu()

		switch leComando() {
		case 1:
			iniciarMonitoramento()
		case 2:
			fmt.Println("Exibindo logs")
		case 0:
			fmt.Println("Saindo..")
			os.Exit(0)
		default:
			fmt.Println("Comando não reconhecido")
		}
	}

}

func exibeMenu() {
	fmt.Println("1 - Iniciar Monitoramento")
	fmt.Println("2 - Exibir Logs")
	fmt.Println("0 - Sair do programa")
}

func leComando() int {

	var comando int
	//fmt.Scanf("%d", &comando)
	fmt.Scan(&comando)

	return comando

}

func exibeIntroducao() {

	nome := "thiago"
	versao := 1.1 // inferencia do nome var e tipo

	fmt.Println("Hello ", nome)
	fmt.Println("", versao)

}

func iniciarMonitoramento() {
	fmt.Println("Monitorando")

	site := "https://www.alura.com.br"

	resp, _ := http.Get(site)

	if resp.StatusCode == 200 {
		fmt.Println("Site carregado")
	} else {
		fmt.Println("Erro status:", resp.StatusCode)
	}

}

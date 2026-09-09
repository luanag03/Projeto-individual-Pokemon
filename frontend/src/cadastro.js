document.addEventListener("DOMContentLoaded", async function () {
    const selectPokemon = document.getElementById("pokemon");

    try {
        const resposta = await fetch("http://localhost:8080/pokemons");
        
        if (resposta.ok) {
            const pokemons = await resposta.json();

            for (let i = 0; i < pokemons.length; i++) {
                const option = document.createElement("option");
                option.value = pokemons[i].nome;
                option.textContent = `${pokemons[i].nome} (${pokemons[i].tipo})`;
                selectPokemon.appendChild(option);
            }
        }
    } catch (erro) {
        console.error("Erro ao carregar os pokémons:", erro);
    }
});

const formCadastro = document.getElementById("formCadastro");

formCadastro.addEventListener("submit", async function (evento) {
    evento.preventDefault();


    const nome = document.getElementById("nome").value.trim();
    const nickname = document.getElementById("nickname").value.trim();
    const email = document.getElementById("email").value.trim();
    const idadeValor = document.getElementById("idade").value;
    const dataNascimento = document.getElementById("dataNascimento").value;
    const sexoSelecionado = document.querySelector('input[name="sexo"]:checked');
    const pokemonEscolhidoValor = document.getElementById("pokemon").value;
    const senha = document.getElementById("senha").value;

    const tiposCheckbox = document.getElementsByName('tipo');
    let tiposFavoritosArray = [];

    for (let i = 0; i < tiposCheckbox.length; i++) {
        if (tiposCheckbox[i].checked) {
            tiposFavoritosArray.push(tiposCheckbox[i].value);
        }
    }


    if (nome === "") {
        alert("Por favor, preencha o seu nome.");
        return;
    }

    if (nickname === "") {
        alert("Por favor, escolha um nickname.");
        return;
    }

    if (email === "") {
        alert("Por favor, preencha o e-mail.");
        return;
    }

    if (!email.includes("@") || !email.includes(".com")) {
            alert("O e-mail precisa conter '@' e '.com' para ser válido.");
            return;
        }

    if (idadeValor === "" || Number(idadeValor) <= 0) {
        alert("Por favor, informe uma idade válida.");
        return;
    }

    if (dataNascimento === "") {
        alert("Por favor, informe a data de nascimento.");
        return;
    }

    if (!sexoSelecionado) {
        alert("Por favor, selecione o sexo.");
        return;
    }

    if (tiposFavoritosArray.length === 0) {
        alert("Por favor, selecione pelo menos um tipo favorito.");
        return;
    }

    if (pokemonEscolhidoValor === "" || pokemonEscolhidoValor === "Selecione") {
        alert("Por favor, escolha o seu Pokémon inicial.");
        return;
    }

    const temNumero = /\d/.test(senha);
    const temSimbolo = /[!@#$%^&*(),.?":{}|<>_\-\/\\]/.test(senha);

    if (senha === "") {
        alert("Por favor, digite uma senha.");
        return;
    }

    if (senha.length < 6) {
            alert("A senha precisa ter no mínimo 6 caracteres.");
            return;
        }

        if (!temNumero) {
            alert("A senha precisa conter pelo menos um número.");
            return;
        }

        if (!temSimbolo) {
            alert("A senha precisa conter pelo menos um símbolo/caractere especial (ex: @, #, $, !).");
            return;
        }

    const novoUsuario = {
        nome: nome,
        nickname: nickname,
        email: email,
        idade: Number(idadeValor),
        dataNascimento: dataNascimento,
        sexo: sexoSelecionado ? sexoSelecionado.value : "",
        tiposFavoritos: tiposFavoritosArray.join(","),
        pokemonInicial: pokemonEscolhidoValor,
        senha: senha
    };

    try {
        const resposta = await fetch("http://localhost:8080/usuarios/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(novoUsuario)
        });

        if (resposta.status === 201) {
            localStorage.setItem("pokemonEscolhido", pokemonEscolhidoValor.toLowerCase());

            alert("Jornada iniciada com sucesso! Faça login.");
            window.location.href = "login.html";
        } else {
            alert("Erro ao realizar o cadastro. Verifique os dados.");
        }
    } catch (erro) {
        console.error("Erro na requisição:", erro);
        alert("Não foi possível conectar ao servidor.");
    }
});
const formLogin = document.getElementById("formLogin");

formLogin.addEventListener("submit", async function (evento) {
    evento.preventDefault(); 

    const emailInput = document.getElementById("email").value;
    const senhaInput = document.getElementById("senha").value;

    const usuarioLogin = {
        email: emailInput,
        senha: senhaInput
    };

    try {
        const resposta = await fetch("http://localhost:8080/usuarios/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuarioLogin)
        });

        if (resposta.status === 200) {
            const usuarioRetornado = await resposta.json();
     
            localStorage.setItem("usuarioLogado", JSON.stringify(usuarioRetornado));

        
            if (usuarioRetornado.pokemonInicial) {
                localStorage.setItem("pokemonEscolhido", usuarioRetornado.pokemonInicial.toLowerCase());
            }

            alert("Login realizado com sucesso! Retomando jornada...");
            
            window.location.href = "pokemon.html"; 
        } else {
            alert("E-mail ou senha incorretos.");
        }
    } catch (erro) {
        console.error("Erro na requisição:", erro);
        alert("Não foi possível conectar ao servidor.");
    }
});

const validation = (values) => {

    let errors = {};

    if (!values.name.trim()) {
        errors.nomecompleto = 'Nome em branco';
    }
    else if (!/^[A-Za-z]+/.test(values.name.trim())) {
        errors.name = 'Enter a valid name';
    }

    if (!values.email) {
        errors.email = 'Email em branco';
    } else if (!/\S+@\S+\.\S+/.test(values.email)) {
        errors.email = 'Email address is invalid';
    }
    if (!values.senha) {
        errors.senha = 'Senha em branco';
    } else if (values.senha.length < 6) {
        errors.passsenhaword = 'A senha precisa ter no mínimo 6 caractéres';
    }

  /*   if (values.cpf.length < 12) {
        errors.cpf = 'Digite um CPF válido'
    } else if (values.cnpj.length < 14) {
        errors.cnpj = 'Digite um CNPJ válido';
    }
    if(!values.cep) {
        errors.cep = 'Digite o CEP';
    } */


    return errors;
}

export default validation;
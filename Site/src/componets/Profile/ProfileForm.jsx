import Input from "./Form/Input";
import validation from "../Cadastro/validation";
import useForm from "../Cadastro/useForm";

const ProfileForm = ({ submitForm }) => {
    const { handleChange, handleFormSubmit, values, errors, validation } = useForm(submitForm);

    return (

        <>
            <div className="bodyPro" id="bodyPro" >
                <h2 className='titleForm'>Configurar Perfil</h2>
                <form className="formProfile">
                    <label className="info_contato">Informações de contato</label>
                    <div className='personal_info'>

                        <div className="label-text">
                            <Input
                                type="text"
                                text="Nome"
                                name="name"
                                placeholder=""
                                value={values.nome}
                                onChange={handleChange}
                            />
                            {errors.nomecompleto && <p className="error">{errors.nomecompleto}</p>}


                        </div>

                        <Input
                            type="text"
                            text="Sobrenome"
                            name="lastname"
                            placeholder=""
                            value={values.name}
                            onChange={handleChange}
                        />
                        {errors.nomecompleto && <p className="error">{errors.nomecompleto}</p>}


                        <Input
                            type="text"
                            text="CPF"
                            name="cpf"
                            placeholder="000.000.000-00..."
                            value={values.cpf}
                            onChange={handleChange}
                        />

                        <Input
                            type="text"
                            text="CNPJ"
                            name="cnpj"
                            placeholder="00.000.0000-00"
                            value={values.cnpj}
                            onChange={handleChange}
                        />

                        <Input
                            type="date"
                            text="Data de Nascimento"
                            name="date"
                        />

                        <Input
                            type="email"
                            text="Email"
                            name="email"
                            placeholder="email@email.com"
                            value={values.email}
                            onChange={handleChange}
                        />
                        {errors.email && <p className="error">{errors.email}</p>}


                        <Input
                            type="text"
                            text="Celular"
                            name="phone"
                            placeholder="91234-5678" />

                        <span className="border"></span>

                    </div>


                    <label className="info_adress">Endereço</label>
                    <div className='adress_info'>
                        <Input
                            type="text"
                            text="CEP"
                            name="cep"
                            placeholder="00000-000"
                            value={values.cep}
                            onChange={handleChange}
                        />

                        <Input
                            type="text"
                            text="Bairro"
                            name="bairro"
                        />

                        <Input
                            type="text"
                            text="Logradouro"
                            name="street"
                        />

                        <Input
                            type="text"
                            text="Número"
                            name="number"
                        />

                        <Input
                            type="text"
                            text="Complemento"
                            name="complemento"
                        />
                    </div>

                    <button className="btnAtt" type="submit" onClick={handleFormSubmit}>Atualizar dados</button>

                </form>
            </div>

        </>

    );

};

export default ProfileForm;
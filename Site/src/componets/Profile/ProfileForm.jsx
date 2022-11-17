import Input from "./Form/Input";

function ProfileForm() {

    return (

        <>
            <div className="bodyPro">
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
                            />
                        </div>

                        <Input
                            type="text"
                            text="Sobrenome"
                            name="lastname"
                            placeholder="" />

                        <Input
                            type="text"
                            text="CPF"
                            name="cpf"
                            placeholder="000.000.000-00..." />

                        <Input
                            type="text"
                            text="CNPH"
                            name="cnpj"
                            placeholder="00.000.0000-00" />

                        <Input
                            type="date"
                            text="Data de Nascimento"
                            name="date"

                        />

                        <Input
                            type="email"
                            text="Email"
                            name="email"
                            placeholder="email@email.com" />

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
                            placeholder="00000-000" />

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

                    <button className="btnAtt" type="submit">Atualizar dados</button>

                </form>
            </div>

        </>

    )

}

export default ProfileForm;
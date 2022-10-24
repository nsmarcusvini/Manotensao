import React, { useState, useEffect } from "react";
import validation from "./validation";


const useForm = (submitForm) => {
    const [values, setValues] = useState({
        name: "",
        email: "",
        senha: "",
    });

    const [errors, setErros] = useState({});
    const [dataIsCorret, setDataIsCorrect] = useState(false);

    const handleChange = (event) => {
        setValues({
            ...values,
            [event.target.name]: event.target.value,
        });
    };

    const handleFormSubmit = (event) => {
        event.preventDefault();
        setErros(validation(values));
        setDataIsCorrect(true);
    };

    useEffect(() => {
        if (Object.keys(errors).length === 0 && dataIsCorret) {
            submitForm(true);
        }

    }, [errors]);

    return { handleChange, handleFormSubmit, errors, values };
}

export default useForm;
import React, { useState } from "react";
import SignUpForm from "./SignUpForm";
import SignUpFormSucess from "./SignUpFormSucess";

const Form = () => {
  const [formIsSubmitted, setFormIsSubmitted] = useState(false);

  const submitForm = () => {
    setFormIsSubmitted(true);
  };

  return (
    <div>{!formIsSubmitted ? <SignUpForm submitForm={submitForm} /> : <SignUpFormSucess />}</div>
  )
}

export default Form;

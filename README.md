# online-chat-application
springMVC+thymeleaf, with authentication and hashservice

难点在于：
Connecting Controllers to Templates：see how to bind data from a web form to a controller method.

On the template side, we need to define input fields for each piece of data we want to capture, and a <form> element to group them. When the form is submitted, the data will be encoded in the HTTP request that is sent, and can be extracted on the Spring side.

On the Spring side of things, we need to define a POJO to hold the form data. We'll look at code details in the next video, but by defining this POJO we can pre-fill the form by setting its fields and adding it as a Model attribute when first rendering the template, and Spring can automatically extract the request data into that POJO when the form is submitted. 
  
 @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

 @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }
  
For the GET request handling method, we declare the MessageForm argument to ensure that the object exists and is added to the model by Spring automatically. This is necessary, because Thymeleaf needs an object with the name newMessage to be present in the model to render properly, even if there isn't any data in the object yet.

For the POST request handling method, we declare the MessageForm argument to tell Spring that it should look for data that matches that in the body of the request we're handling. Spring will then automatically extract that data and put it in a MessageForm object before calling our method, passing it to us so we can use the data as we see fit.

In both cases, we're annotating this argument with @ModelAttribute. This allows us to specify that Spring should add the object to our Model before asking Thymeleaf to render the template. That means we don't have to add it manually! Pretty handy.

Key Terms
Form-Backing Object: This is a term used by Spring MVC and Thymeleaf to mean an object that represents the data contained in a form. On the Spring side, this is usually an additional argument to the relevant Controller method, and on the Thymeleaf side, this is referred to in the th:object attribute on the form.

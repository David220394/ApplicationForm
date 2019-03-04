package com.applicationform.entities;

import java.util.ResourceBundle;

public enum FxmlView {

    REGISTRATION {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("form.title");
        }

        @Override
		public String getFxmlFile() {
            return "/template/form.fxml";
        }
    }, 
    LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/template/login.fxml";
        }
    },
    FORM2 {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("form2.title");
        }

        @Override
        public String getFxmlFile() {
            return "/template/form2.fxml";
        }
    },
    FORM3 {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("form3.title");
        }

        @Override
        public String getFxmlFile() {
            return "/template/form3.fxml";
        }
    },
    INDEX {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("index.title");
        }

        @Override
        public String getFxmlFile() {
            return "/template/index.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
(ns design-system.core
  (:require
   [design-system.icons]
   [design-system.button.element]
   [design-system.combobox.element]))

(def e-button-secondary #'design-system.button.element/secondary)
(def e-combobox         #'design-system.combobox.element/view)

(def i-chevron-down design-system.icons/chevron-down)
(def i-search       design-system.icons/search)
(def i-build        design-system.icons/build)

(defn doc [element-ref]
  (require 'hiccup.core)
  (require 'clojure.java.io)
  (require 'clojure.java.browse)
  (let [element-namespace (-> element-ref meta :ns str)]
    (-> (str element-namespace ".html")
        (clojure.java.io/resource)
        (str)
        (clojure.java.browse/browse-url))))

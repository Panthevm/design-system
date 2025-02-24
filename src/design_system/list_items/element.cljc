(ns design-system.list-items.element
  (:require [design-system.utils :as utils]))

(defn item [& args]
  (let [attrs   (utils/get-element-attributes args)
        content (utils/get-element-content args)]
    (into [:li.ds-list-item attrs]
          content)))

(defn view [& args]
  (let [attrs   (utils/get-element-attributes args)
        content (utils/get-element-content args)]
    (into [:ul.ds-list-items attrs] content)))

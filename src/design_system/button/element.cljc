(ns design-system.button.element
  (:require [design-system.utils :as utils]))

(defn view [& args]
  (let [attrs      (utils/get-element-attributes args)
        content    (utils/get-element-content args)
        slot-right (:slot/right attrs)]
    [:button.ds-button (dissoc attrs :slot/right)
     (into [:span.ds-button-content] content)
     (when slot-right [:span.ds-button-right slot-right])]))

(defn secondary [& args]
  (let [attrs   (utils/get-element-attributes args)
        content (utils/get-element-content args)]
    (apply view
           (update attrs :class #(utils/merge-classes "ds-button-secondary ds-text-button" %))
           content)))

(comment
  (design-system.core/doc #'view)
  (user/update-element-docs #'view))

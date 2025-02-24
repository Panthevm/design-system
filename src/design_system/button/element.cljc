(ns design-system.button.element)

(defn view [props & content]
  [:button.ds-button props content])

(defn secondary [props & content]
  (apply view props content))

(comment
  (design-system.core/doc #'view)
  (user/update-element-docs #'view))

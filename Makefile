init:
	npm install

repl:
	clj -M:dev:repl

watch:
	npx @tailwindcss/cli -i ./src/design_system/style.css -o ./resources/public/design_system.css --watch

release:
	npx @tailwindcss/cli -i ./src/design_system/style.css -o ./resources/public/design_system.css --release
